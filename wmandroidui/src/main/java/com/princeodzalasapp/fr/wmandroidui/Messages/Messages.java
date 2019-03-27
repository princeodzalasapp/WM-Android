package com.princeodzalasapp.fr.wmandroidui.Messages;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.princeodzalasapp.fr.wmandroidui.Models.Dialog;
import com.princeodzalasapp.fr.wmandroidui.Models.Message;
import com.princeodzalasapp.fr.wmandroidui.Models.User;
import com.princeodzalasapp.fr.wmandroidui.R;
import com.princeodzalasapp.fr.wmandroidui.Utiles.ErreurJava;
import com.princeodzalasapp.fr.wmandroidui.Utiles.ToastColor;
import com.stfalcon.chatkit.commons.ImageLoader;
import com.stfalcon.chatkit.dialogs.DialogsList;
import com.stfalcon.chatkit.dialogs.DialogsListAdapter;
import com.stfalcon.chatkit.messages.MessageInput;
import com.stfalcon.chatkit.messages.MessagesList;
import com.stfalcon.chatkit.messages.MessagesListAdapter;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import static com.princeodzalasapp.fr.wmandroidui.Utiles.Services.getAppContext;

public class Messages {

    public static DialogsList dialogsList;
    public static String[] reponse;
    public static String[] reponseConversation;
    public static DialogsListAdapter<Dialog> dialogsAdapter;
    public static MessagesListAdapter<Message> messagesAdapter;
    public static MessagesList messagesList;
    public static ImageLoader imageLoader;
    public static int selectionCount;


    public static ViewGroup MessageView(final int idParent,final ArrayList<Dialog> chats, final Activity mActivity) {

        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            RelativeLayout fen = (RelativeLayout) inflater.inflate(R.layout.message,null);
            dialogsList = fen.findViewById(R.id.dialogsList);

            imageLoader = new ImageLoader() {
                @Override
                public void loadImage(ImageView imageView, String url, Object payload) {
                    Glide.with(mActivity).load(url).into(imageView);
                }
            };
            dialogsAdapter  = new DialogsListAdapter<Dialog>(imageLoader);
            //Données
            dialogsAdapter.setItems(chats);
            dialogsList.setAdapter(dialogsAdapter);
            dialogsAdapter.setOnDialogClickListener(new DialogsListAdapter.OnDialogClickListener<Dialog>() {
                @Override
                public void onDialogClick(Dialog dialog) {
                    reponse[0] = dialog.getId();
                    reponse[1] = dialog.getDialogPhoto();
                    reponse[2] = dialog.getDialogName();
                    reponse[3] = "NON";
                }
            });
            dialogsAdapter.setOnDialogLongClickListener(new DialogsListAdapter.OnDialogLongClickListener<Dialog>() {
                @Override
                public void onDialogLongClick(Dialog dialog) {
                    reponse[3] = "OUI";
                }
            });
            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(fen);
            }
            return parent;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }
    }

    public static ViewGroup ConversationView(final int idParent, final String sIdConversation,final User mUser, final Message msg,final ArrayList<Message> messages, final Activity mActivity){

        try {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            RelativeLayout fen = (RelativeLayout) inflater.inflate(R.layout.conversation,null);

            imageLoader = new ImageLoader() {
                @Override
                public void loadImage(ImageView imageView, String url, Object payload) {
                    Glide.with(mActivity).load(url).into(imageView);
                }
            };

            messagesList = fen.findViewById(R.id.messagesList);
            messagesAdapter = new MessagesListAdapter<Message>(sIdConversation, imageLoader);
            messagesAdapter.addToStart(msg, true);
            messagesAdapter.enableSelectionMode(new MessagesListAdapter.SelectionListener() {
                @Override
                public void onSelectionChanged(int count) {
                    selectionCount = count;
                    if ( selectionCount > 0 ){
                        reponseConversation[0] = "1";
                    }else{
                        reponseConversation[0] = "0";
                    }
                    //adapter.copySelectedMessagesText(getActiviteEnCours(), message -> message.getText(), false);
                }
            });

            messagesAdapter.setLoadMoreListener(new MessagesListAdapter.OnLoadMoreListener() {
                @Override
                public void onLoadMore(int page, int totalItemsCount) {
                    new Handler().postDelayed(new Runnable() { //imitation of internet connection
                        @Override
                        public void run() {
                            messages.get(messages.size() - 1).getCreatedAt();
                            messagesAdapter.addToEnd(messages, false);
                        }
                    }, 1000);
                }
            });

            messagesAdapter.registerViewClickListener(R.id.bubble, new MessagesListAdapter.OnMessageViewClickListener<Message>() {
                @Override
                public void onMessageViewClick(View view, Message message) {
                    reponseConversation[1] = message.getUser().getName();
                }
            });
            messagesAdapter.registerViewClickListener(R.id.messageUserAvatar, new MessagesListAdapter.OnMessageViewClickListener<Message>() {
                @Override
                public void onMessageViewClick(View view, Message message) {
                    reponseConversation[2] = message.getUser().getName();
                }
            });

            messagesList.setAdapter(messagesAdapter);
//
            MessageInput input = fen.findViewById(R.id.input);
            input.setInputListener(new MessageInput.InputListener() {
                @Override
                public boolean onSubmit(CharSequence input) {
                    messagesAdapter.addToStart(getTextMessage(input.toString(), mUser), true);
                    return true;
                }
            });

            input.setTypingListener(new MessageInput.TypingListener() {
                @Override
                public void onStartTyping() {
                    //Log.v("Typing listener", getString(R.string.start_typing_status));
                }
                @Override
                public void onStopTyping() {
                    //Log.v("Typing listener", getString(R.string.stop_typing_status));
                }
            });
            input.setAttachmentsListener(new MessageInput.AttachmentsListener() {
                @Override
                public void onAddAttachments() {
                    //messagesAdapter.addToStart( getImageMessage(), true);
                }
            });


            ViewGroup parent = mActivity.findViewById(idParent);
            if(parent != null){
                parent.addView(fen);
            }
            return parent;
        } catch ( Exception e ) {
            ErreurJava.set(mActivity, e.getMessage());
            return null;
        }

    }

    public static Message getTextMessage(String text, User mUser) {
        return new Message(getRandomId(), mUser, text);
    }

    public static void MessageCopy(MessagesListAdapter<Message> mAdapter, final Activity mActivity){
        mAdapter.copySelectedMessagesText(mActivity, getMessageStringFormatter(), true);
        ToastColor.succes("Copier !", getAppContext(mActivity));
    }

    public static void MessageDeselect(MessagesListAdapter<Message> mAdapter){
        if (selectionCount != 0) {
            mAdapter.unselectAllItems();
        }

    }

    public static void MessageSup(MessagesListAdapter<Message> mAdapter){
        mAdapter.deleteSelectedMessages();
    }

    public static MessagesListAdapter.Formatter<Message> getMessageStringFormatter() {
        return new MessagesListAdapter.Formatter<Message>() {
            @Override
            public String format(Message message) {
                String createdAt = new SimpleDateFormat("MMM d, EEE 'à' h:mm a", Locale.getDefault())
                        .format(message.getCreatedAt());

                String text = message.getText();
                if (text == null) text = "[Pièce jointe]";

                return String.format(Locale.getDefault(), "%s: %s (%s)",
                        message.getUser().getName(), text, createdAt);
            }
        };
    }

    public static SecureRandom rnd = new SecureRandom();

    public static void onNewMessage(String dialogId, Message message) {
        boolean isUpdated = dialogsAdapter.updateDialogWithMessage(dialogId, message);
        if (!isUpdated) {
            //Dialog with this ID doesn't exist, so you can create new Dialog or update all dialogs list
        }
    }
    public static void onNewDialog(Dialog dialog) {
        dialogsAdapter.addItem(dialog);
    }
    public static String getRandomId() {
        return Long.toString(UUID.randomUUID().getLeastSignificantBits());
    }
    public static boolean getRandomBoolean() {
        return rnd.nextBoolean();
    }

}

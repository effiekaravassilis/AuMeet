package com.bignerdranch.android.aumeet;

import android.app.Application;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class ProfileViewHolder extends RecyclerView.ViewHolder {

    TextView textViewName, textViewMajor, viewUserprofile, sendmessagebtn;
    ImageView imageView, iv_ll, iv_follower;
    CardView cardView;

    public ProfileViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void setProfile(FragmentActivity fragmentActivity, String name, String uid, String major,
                           String url) {


        cardView = itemView.findViewById(R.id.cardview_profile);
        textViewName = itemView.findViewById(R.id.tv_name_profile);
        textViewMajor = itemView.findViewById(R.id.tv_major_profile);
        viewUserprofile = itemView.findViewById(R.id.viewUser_profile);
        imageView = itemView.findViewById(R.id.profile_imageview);

        Picasso.get().load(url).into(imageView);
        textViewName.setText(name);
        textViewMajor.setText(major);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String currentuid = user.getUid();

    }


    public void setProfileInChat(Application application, String name, String uid, String major,
                                 String url) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userid = user.getUid();

        ImageView imageView = itemView.findViewById(R.id.iv_ch_item);
        TextView nametv = itemView.findViewById(R.id.name_ch_item_tv);
        TextView majortv = itemView.findViewById(R.id.ch_itemmajor_tv);
        sendmessagebtn = itemView.findViewById(R.id.sendmessagech_item_btn);


        if (userid.equals(uid)) {
                       Picasso.get().load(url).into(imageView);
                       nametv.setText(name);
                       majortv.setText(major);
                       sendmessagebtn.setVisibility(View.INVISIBLE);
        } else {
            Picasso.get().load(url).into(imageView);
            nametv.setText(name);
            majortv.setText(major);
        }
    }
}





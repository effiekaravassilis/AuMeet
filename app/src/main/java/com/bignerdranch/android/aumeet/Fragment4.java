package com.bignerdranch.android.aumeet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

public class Fragment4 extends Fragment implements View.OnClickListener{

    ImageView imageView;
    TextView nameEt, majorEt, bioEt, emailEt, scheduleEt;
    ImageButton ib_edit,imageButtonMenu;
    DocumentReference reference;
    FirebaseFirestore firestore;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment4,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        imageView = getActivity().findViewById(R.id.iv_f4);
        nameEt = getActivity().findViewById(R.id.tv_name_f4);
        majorEt = getActivity().findViewById(R.id.tv_major_f4);
        bioEt = getActivity().findViewById(R.id.tv_bio_f4);
        emailEt = getActivity().findViewById(R.id.tv_email_f4);
        scheduleEt = getActivity().findViewById(R.id.tv_schedule_f4);

        ib_edit = getActivity().findViewById(R.id.ib_edit_f4);
        imageButtonMenu = getActivity().findViewById(R.id.ib_menu_f4);

        imageButtonMenu.setOnClickListener(this);
        ib_edit.setOnClickListener(this);
        imageView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.ib_edit_f4:
                Intent intent = new Intent(getActivity(), UpdateProfile.class);
                startActivity(intent);
                break;
            case R.id.ib_menu_f4:
                BottomSheetMenu bottomSheetMenu = new BottomSheetMenu();
                bottomSheetMenu.show(getFragmentManager(),"bottomsheet");
                break;
            case R.id.iv_f4:
                Intent intent1 = new Intent(getActivity(),ImageActivity.class);
                startActivity(intent1);
                break;

        }
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String currentid = user.getUid();
        DocumentReference reference;
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();

        reference = firestore.collection("user").document(currentid);

        reference.get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                        if (task.getResult().exists()) {

                            String nameResult = task.getResult().getString("name");
                            String bioResult = task.getResult().getString("bio");
                            String emailResult = task.getResult().getString("email");
                            String scheduleResult = task.getResult().getString("schedule");
                            String url = task.getResult().getString("url");
                            String majorResult = task.getResult().getString("major");

                            Picasso.get().load(url).into(imageView);
                            nameEt.setText(nameResult);
                            bioEt.setText(bioResult);
                            emailEt.setText(emailResult);
                            scheduleEt.setText(scheduleResult);
                            majorEt.setText(majorResult);


                        }else {
                            Intent intent = new Intent(getActivity(),CreateProfile.class);
                            startActivity(intent);
                        }

                    }
                });

    }
}

package com.example.hrapp.admin.userManagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hrapp.R;
import com.example.hrapp.admin.AdminPannel;
import com.example.hrapp.admin.adapter.UsersRvAdapter;
import com.example.hrapp.login.LoginActivity;
import com.example.hrapp.models.Models;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Collections;

import static com.example.hrapp.admin.userManagement.NewUser.NEW_USER;
import static com.example.hrapp.models.Models.Users.UID;

public class ShowUserInfo extends AppCompatActivity {
    //todo edit data
    Models.Users usersM = new Models.Users();
    Models.Users oldModel = new Models.Users();

    private boolean newUser = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user_info);

        newUser = Boolean.parseBoolean(getIntent().getExtras().get(NEW_USER).toString());

        Toolbar userDataTb = findViewById(R.id.userDataTb);
        setSupportActionBar(userDataTb);
        userDataTb.setNavigationOnClickListener(v -> signOut());

        if (!getIntent().getExtras().get(UID).toString().isEmpty()) {
            populateList(getIntent().getExtras().get(UID).toString());
        } else {
            Toast.makeText(this, "No UID", Toast.LENGTH_SHORT).show();
        }

        Button doneButton = findViewById(R.id.doneButton);
        doneButton.setOnClickListener(v -> signOut());

    }

    private void signOut() {
       if (newUser) {
           Toast.makeText(this, "You will be signed out", Toast.LENGTH_SHORT).show();
           FirebaseAuth.getInstance().signOut();
           updateUi(FirebaseAuth.getInstance().getCurrentUser());
       } else {
           finish();
       }
    }

    private void updateUi(FirebaseUser currentUser) {
        if (currentUser != null) {
            System.out.println("Signed in");
            Toast.makeText(ShowUserInfo.this, "Signed in", Toast.LENGTH_SHORT).show();
        } else {
            System.out.println("Signed out");
            Toast.makeText(ShowUserInfo.this, "Signed out", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ShowUserInfo.this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
        }
    }


    private void updateUser() {
        Toast.makeText(this, "Do later", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void populateList(String uid) {
        UsersViewModel usersViewModel = new ViewModelProvider(this).get(UsersViewModel.class);
        usersViewModel.getUsersData(uid).observe(this, this::setUserData);
    }

    private void setUserData(Models.Users users) {

        oldModel = users;
        usersM = users;

        TextView nameField = findViewById(R.id.dialogNameTv);
        nameField.setText(users.getFirst_name().concat(" ").concat(users.getLast_name()));
        TextView emailField = findViewById(R.id.dialogEmailTv);
        emailField.setText(users.getEmail_address());

        TextView phone_number_field = findViewById(R.id.dialogNumberTv);
        phone_number_field.setText(users.getPhone_number());
        TextView password_field = findViewById(R.id.dialog_secret_key);
        password_field.setText(users.getSecret_key());
        TextView dialogRoleTv = findViewById(R.id.dialogRoleTv);
        dialogRoleTv.setText(users.getRole());

        TextView position_field = findViewById(R.id.dialogPositionTv);
        position_field.setText(users.getPosition());
        TextView kra_number_field = findViewById(R.id.dialogKraTv);
        kra_number_field.setText(users.getKraPin());
        TextView nssf_number_field = findViewById(R.id.dialogNssfTv);
        nssf_number_field.setText(users.getNssf());

        TextView nationalId_number_field = findViewById(R.id.dialogIdTv);
        nationalId_number_field.setText(users.getNationalId());
        TextView nhfi_number_field = findViewById(R.id.dialogNhifTv);
        nhfi_number_field.setText(users.getNhif());
        TextView dialogDateJoinedTv = findViewById(R.id.dialogDateJoinedTv);
        dialogDateJoinedTv.setText(users.getCreatedAt());

        TextView dialogDobTv = findViewById(R.id.dialogDobTv);
        dialogDobTv.setText(users.getDate_of_birth());
        TextView performance = findViewById(R.id.userPerformanceTv);
        performance.setText(users.getPerformance_ratings());
        TextView wage = findViewById(R.id.wageTv);
        wage.setText(users.getWage());
    }
}
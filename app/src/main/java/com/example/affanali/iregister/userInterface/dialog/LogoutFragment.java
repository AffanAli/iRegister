package com.example.affanali.iregister.userInterface.dialog;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.example.affanali.iregister.MainActivity;


public class LogoutFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Are you Sure, you want to logout?")
                .setTitle("Logout Confirmation")
                .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                .setNegativeButton("Confirm", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // action on press of confirm button
                        Intent i = new Intent(getActivity(), MainActivity.class);
                        startActivity(i);
                    }
                });

        // Create the AlertDialog object and return it
        return builder.create();
    }
}
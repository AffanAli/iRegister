package com.example.affanali.iregister.userInterface.dialog;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.affanali.iregister.MainActivity;
import com.example.affanali.iregister.R;

import java.util.List;


public class DeleteDialog extends DialogFragment {

    List<String> record;

    // design constraints
    final int paddingL = 35;
    final int paddingR = 15;
    final int paddingT = 15;
    final int paddingB = 15;

    public DeleteDialog() {}

    public void setData(List<String> object) {
        record = object;
    }

    public void render_data(LinearLayout ly) {
        for (int i=0; i<this.record.size(); i++) {
            LinearLayout subLinear = new LinearLayout(getActivity());
            subLinear.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams layoutForOuter = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            subLinear.setLayoutParams(layoutForOuter);

            TextView Name = new TextView(getActivity());
            Name.setText("Col Name : ");
            Name.setPadding(paddingL, paddingT, paddingR, paddingB);
            subLinear.addView(Name);

            TextView Value = new TextView(getActivity());
            Value.setText(record.get(i));
            Value.setPadding(paddingL+paddingL, paddingT, paddingR, paddingB);
            subLinear.addView(Value);

            ly.addView(subLinear);
        }
    }

    private View render() {
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        // get the current view
        View view = inflater.inflate(R.layout.dialog_delete, null);
        /*
            update the current view
            1. get the placeholder where to render field
            2. render field dynamically in current view
         */
        LinearLayout ly = view.findViewById(R.id.dailyExpenseField);
        this.render_data(ly);
        return view;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = render();

        builder.setView(view)
                .setMessage("Are you Sure, you want to delete this record?")
                .setTitle("Confirmation")
                .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {       dialog.cancel();
                    }
                })
                .setNegativeButton("Confirm", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) { deleteObj();
                    }
                });

        // Create the AlertDialog object and return it
        return builder.create();
    }

    private void deleteObj() {

    }
}
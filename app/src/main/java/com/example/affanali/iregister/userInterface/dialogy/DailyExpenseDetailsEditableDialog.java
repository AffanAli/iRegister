package com.example.affanali.iregister.userInterface.dialogy;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.affanali.iregister.R;

import java.util.List;


public class DailyExpenseDetailsEditableDialog extends DialogFragment {

    List<String> expense;

    // design constraints
    final int paddingL = 35;
    final int paddingR = 15;
    final int paddingT = 15;
    final int paddingB = 15;

    public DailyExpenseDetailsEditableDialog() { }

    public void setData(List<String> list) {
        expense = list;
    }

    public void render_data(LinearLayout ly) {
        for (int i=0; i<this.expense.size(); i++) {
            LinearLayout subLinear = new LinearLayout(getActivity());
            subLinear.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams layoutForOuter = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            subLinear.setLayoutParams(layoutForOuter);

            TextView Name = new TextView(getActivity());
            Name.setText("Col Name : ");
            Name.setPadding(paddingL, paddingT, paddingR, paddingB);
            subLinear.addView(Name);

            EditText Value = new EditText(getActivity());
            Value.setText(expense.get(i));
            Value.setPadding(paddingL+paddingL, paddingT, paddingR, paddingB);
            subLinear.addView(Value);

            ly.addView(subLinear);
        }
    }

    private View render() {
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        // get the current view
        View view = inflater.inflate(R.layout.fragment_daily_expense_details_editable_dialog, null);
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
                .setTitle("Expense Details")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(), "Record has been updated successfully", Toast.LENGTH_SHORT).show();
                    }
                });

        // Create the AlertDialog object and return it
        return builder.create();
    }
}
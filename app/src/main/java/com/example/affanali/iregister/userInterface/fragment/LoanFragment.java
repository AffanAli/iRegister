package com.example.affanali.iregister.userInterface.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.affanali.iregister.MainActivity;
import com.example.affanali.iregister.R;
import com.example.affanali.iregister.userInterface.dialog.DetailDialog;

import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoanFragment extends Fragment {

    private List tableHeader;
    final int paddingL = 15;
    final int paddingR = 15;
    final int paddingT = 15;
    final int paddingB = 15;


    public LoanFragment() {
        tableHeader = Arrays.asList("Date", "Description", "Amount", "Paid By");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((MainActivity)getActivity()).setActionTitle("Credit Register");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_loan, container, false);
        // retrieved the Scrollable UI component
        ScrollView scrollview = view.findViewById(R.id.loanTable);
        // add the table dynamically
        scrollview.addView(this.GenTable());
        // return the updated view
        return view;
    }

    /*
         Write Table Header and append it in Main layout
      */
    private void GenTableHeader(TableLayout tableLayout) {
        /*
            Adding Table Header
         */

        TextView textView;

        TableRow tableRow = new TableRow(getActivity());
        for (int j=0; j<tableHeader.size(); j++) {
            textView = new TextView(getActivity());
            textView.setText(tableHeader.get(j).toString());
            textView.setPadding(paddingL, paddingT, paddingR, paddingB);
            tableRow.addView(textView);
        }
        tableLayout.addView(tableRow);
    }

    /*
        Write Dummy Record and append it in Main layout
     */
    private TableLayout GenTable() {
        TableLayout tableLayout = new TableLayout(getActivity());
        TextView textView;

        GenTableHeader(tableLayout);

        /*
            Generating Table Dynamically
         */

        for (int i = 0; i < 44; i++) {
            final TableRow tableRow = new TableRow(getActivity());
            for (int j = 0; j < tableHeader.size(); j++) {
                textView = new TextView(getActivity());
                textView.setText("Col");
                textView.setPadding(paddingL, paddingT, paddingR, paddingB);
                tableRow.addView(textView);
                tableRow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DetailDialog alert = new DetailDialog();
                        alert.setData(Arrays.asList("col1", "col1", "col1", "col1"));
                        alert.setTitle("Loan Details");
                        android.support.v4.app.FragmentManager fm = getFragmentManager();
                        alert.show(fm, "loanDetails");
                    }
                });
            }
            tableLayout.addView(tableRow);
        }
        return tableLayout;
    }
}

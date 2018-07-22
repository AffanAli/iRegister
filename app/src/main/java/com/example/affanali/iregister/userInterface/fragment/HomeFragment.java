package com.example.affanali.iregister.userInterface.fragment;


import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.affanali.iregister.MainActivity;
import com.example.affanali.iregister.R;
import com.example.affanali.iregister.userInterface.dialogy.DailyExpenseDetailsDialog;

import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private List tableHeader;
    private int paddingL;
    private int paddingR;
    private int paddingT;
    private int paddingB;

    public HomeFragment() {
        tableHeader = Arrays.asList("Date", "Description", "Amount", "Paid By");
        paddingL = 15;
        paddingR = 15;
        paddingT = 15;
        paddingB = 15;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((MainActivity)getActivity()).setActionTitle("Home");

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ScrollView scrollview = view.findViewById(R.id.dailyExpenseTable);
        scrollview.addView(this.GenTable());

        // Inflate the layout for this fragment
        return view;
    }

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

    private TableLayout GenTable()
    {
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
                        DailyExpenseDetailsDialog alert = new DailyExpenseDetailsDialog();
                        alert.setData(Arrays.asList("col1", "col1", "col1", "col1"));
                        android.support.v4.app.FragmentManager fm = getFragmentManager();
                        alert.show(fm, "ExpenseDetails");
                    }
                });
            }
            tableLayout.addView(tableRow);
        }
        return tableLayout;
    }

}

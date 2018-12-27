package com.kstransfter.utils;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.kstransfter.R;

import java.util.Calendar;


public class PoupUtils {

    public static void showConfirmationDailog(Activity activity, String message, View.OnClickListener yesClick, View.OnClickListener noClick) {
        final Dialog dialog = new Dialog(activity, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(R.color.black_tran_60);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.layout_dialog);
        TextView txtYes = dialog.findViewById(R.id.txtYes);
        TextView txtNo = dialog.findViewById(R.id.txtNo);
        TextView txtTitle = dialog.findViewById(R.id.txtTitle);
        txtTitle.setText(message);
        txtYes.setOnClickListener(v -> {
            dialog.cancel();
            yesClick.onClick(txtYes);

        });
        txtNo.setOnClickListener(v -> {
            dialog.cancel();
            noClick.onClick(txtNo);
        });
        dialog.show();
    }

    public static void showAlertDailog(Activity activity, String message) {

        final Dialog dialog = new Dialog(activity, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(R.color.black_tran_30);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.layout_alert_dailog);
        TextView txtOK = dialog.findViewById(R.id.txtOK);
        TextView txtTitle = dialog.findViewById(R.id.txtTitle);
        txtTitle.setText(message);

        txtOK.setOnClickListener(v -> {
            dialog.cancel();

        });

        dialog.show();
    }

    private static String date;
    private static DatePickerDialog datePickerDialog;

    public static void showDatePicker(Context context, TextView txtLeaveDate) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        String dateAndTime = txtLeaveDate.getText().toString().trim();
        if (!TextUtils.isEmpty(dateAndTime) && !dateAndTime.equalsIgnoreCase("Select")) {
            String datestimes[] = dateAndTime.split(" ");
            String datesvale = datestimes[0];
            String dates[] = datesvale.split("-");
            mDay = Integer.parseInt(dates[0]);
            int month = Integer.parseInt(dates[1]);
            mMonth = month - 1;
            mYear = Integer.parseInt(dates[2]);
        }
        datePickerDialog = new DatePickerDialog(context,
                (view, year, monthOfYear, dayOfMonth) -> {
                    int month = monthOfYear + 1;
                    String dateValue = view.getDayOfMonth() + "-" + month + "-" + view.getYear();
                    Log.e("date", "" + date);
                    showTimePicker(context, txtLeaveDate, dateValue);
                }, mYear, mMonth, mDay);
          datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
          datePickerDialog.show();
    }

    public static void showTimePicker(Context context, TextView txtLeaveDate, String date) {
        final Calendar c = Calendar.getInstance();
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(context,
                (view, hourOfDay, minute) -> {
                    txtLeaveDate.setText(date + " " + hourOfDay + ":" + minute);
                }, mHour, mMinute, false);
        timePickerDialog.show();
        timePickerDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "cancel",
                (view, which) -> {

                });

        timePickerDialog.setButton(DialogInterface.BUTTON_POSITIVE, "cancel",
                (view, which) -> {

                });

    }

}




package com.example.loginlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Layout;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.Inet4Address;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class profile1 extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    TextView id;
    ImageView img_back, favorite, book_mark;
    boolean favorite_t = true;
    boolean book_mark_t = true;
    private String userID;
    public String readDay = null;
    public String str = null;
    public CalendarView calendarView;
    public Button cha_Btn, del_Btn, save_Btn;
    public TextView diaryTextView, textView2, textView3;
    public ImageView profile2_box, profile2_box1, profile2_memo;
    public EditText contextEditText;
    int index = 0;
    FrameLayout profile_layout, profile2_layout;
    private TextView mTextView;
    Button img_alarmpupple;
    Dialog dilaog1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile1);

        id = findViewById(R.id.tv_id);
        img_back = findViewById(R.id.img_back1);
        img_back.setOnClickListener(v -> onBackPressed());

        favorite = findViewById(R.id.img_favorite);
        book_mark = findViewById(R.id.img_ticket_book);

        profile_layout = findViewById(R.id.profile_layout);;
        profile2_layout = findViewById(R.id.profile2_layout);

        Intent it = getIntent();
        userID = it.getStringExtra("userID");
        id.setText(userID + "님");

        //calendarView = findViewById(R.id.calendarView);
        diaryTextView = findViewById(R.id.diaryTextView);
        save_Btn = findViewById(R.id.save_Btn);
        profile2_box = findViewById(R.id.profile2_box);
        profile2_box1 = findViewById(R.id.profile2_box1);
        profile2_memo = findViewById(R.id.profile2_memoicon);
        del_Btn = findViewById(R.id.del_Btn);
        cha_Btn = findViewById(R.id.cha_Btn);
        textView2 = findViewById(R.id.textView2);
        //textView3 = findViewById(R.id.textView3);
        contextEditText = findViewById(R.id.contextEditText);

        dilaog1 = new Dialog(profile1.this);       // Dialog 초기화
        dilaog1.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        dilaog1.setContentView(R.layout.dialog1);


        MaterialCalendarView materialCalendarView = findViewById(R.id.calendarView);
        materialCalendarView.setSelectedDate(CalendarDay.today());
        materialCalendarView.addDecorators(
                new profile1.SundayDecorator(),
                new profile1.SaturdayDecorator()
        );
        profile1.OneDayDecorator oneDayDecorator = new profile1.OneDayDecorator();
        materialCalendarView.addDecorators(
                oneDayDecorator

        );

        mTextView =  findViewById(R.id.alarmTextView);

        Button button = (Button) findViewById(R.id.alarm_Btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }

        });











//


        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                int Year = date.getYear();
                int Month = date.getMonth() +1;
                int Day = date.getDay();

                profile2_layout.setVisibility(View.INVISIBLE);
                diaryTextView.setVisibility(View.VISIBLE);
                profile_layout.setVisibility(View.VISIBLE);
                    /*

                    profile2_box.setVisibility(View.VISIBLE);
                    save_Btn.setVisibility(View.VISIBLE);
                    contextEditText.setVisibility(View.VISIBLE);

                    textView2.setVisibility(View.INVISIBLE);
                    profile2_box1.setVisibility(View.INVISIBLE);
                    profile2_memo.setVisibility(View.INVISIBLE);
                    cha_Btn.setVisibility(View.INVISIBLE);
                    del_Btn.setVisibility(View.INVISIBLE);
                     */
                diaryTextView.setText(String.format("%d / %d / %d", Year, Month, Day));
                contextEditText.setText("");
                checkDay(Year, Month, Day);


            }
        });

        save_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog1();
                /*
                profile2_box.setVisibility(View.INVISIBLE);
                save_Btn.setVisibility(View.INVISIBLE);
                contextEditText.setVisibility(View.INVISIBLE);

                profile2_box1.setVisibility(View.VISIBLE);
                profile2_memo.setVisibility(View.VISIBLE);
                cha_Btn.setVisibility(View.VISIBLE);
                del_Btn.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                */
            }
        });



    }
    public void showDialog1(){
        dilaog1.show();
        Button noBtn = dilaog1.findViewById(R.id.noBtn);
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 원하는 기능 구현
                dilaog1.dismiss(); // 다이얼로그 닫기
            }
        });
        dilaog1.findViewById(R.id.yesBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 원하는 기능 구현
                saveDiary(readDay);
                str = contextEditText.getText().toString();
                textView2.setText(str);

                profile_layout.setVisibility(View.INVISIBLE);
                profile2_layout.setVisibility(View.VISIBLE);


                dilaog1.dismiss();          // 앱 종료
            }
        });
    }


    public void checkDay(int cYear, int cMonth, int cDay) {

        readDay = "" + cYear + "-" + cMonth + "" + "-" + cDay + ".txt";//저장할 파일 이름설정
        FileInputStream fis;//FileStream fis 변수

        try {
            fis = openFileInput(readDay);

            byte[] fileData = new byte[fis.available()];
            fis.read(fileData);
            fis.close();

            str = new String(fileData);

            /*
            profile2_box.setVisibility(View.INVISIBLE);
            save_Btn.setVisibility(View.INVISIBLE);
            contextEditText.setVisibility(View.INVISIBLE);

            textView2.setVisibility(View.VISIBLE);
            profile2_box1.setVisibility(View.VISIBLE);
            profile2_memo.setVisibility(View.VISIBLE);
            cha_Btn.setVisibility(View.VISIBLE);
            del_Btn.setVisibility(View.VISIBLE);

             */

            profile_layout.setVisibility(View.INVISIBLE);
            profile2_layout.setVisibility(View.VISIBLE);

            textView2.setText(str);

            cha_Btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    profile_layout.setVisibility(View.VISIBLE);
                    profile2_layout.setVisibility(View.INVISIBLE);
                    /*
                    contextEditText.setVisibility(View.VISIBLE);
                    profile2_box.setVisibility(View.VISIBLE);
                    save_Btn.setVisibility(View.VISIBLE);
                     */

                    contextEditText.setText(str);

                    /*
                    textView2.setVisibility(View.INVISIBLE);
                    profile2_box1.setVisibility(View.INVISIBLE);
                    profile2_memo.setVisibility(View.INVISIBLE);
                    cha_Btn.setVisibility(View.INVISIBLE);
                    del_Btn.setVisibility(View.INVISIBLE);
                     */

                    textView2.setText(contextEditText.getText());
                }

            });
            del_Btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    profile_layout.setVisibility(View.VISIBLE);
                    contextEditText.setText("");
                    /*
                    contextEditText.setVisibility(View.VISIBLE);
                    profile2_box.setVisibility(View.VISIBLE);
                    save_Btn.setVisibility(View.VISIBLE);
                     */


                    profile2_layout.setVisibility(View.INVISIBLE);
                    /*
                    textView2.setVisibility(View.INVISIBLE);
                    profile2_box1.setVisibility(View.INVISIBLE);
                    profile2_memo.setVisibility(View.INVISIBLE);
                    cha_Btn.setVisibility(View.INVISIBLE);
                    del_Btn.setVisibility(View.INVISIBLE);
                     */

                    removeDiary(readDay);
                }
            });
            if (textView2.getText() == null) {

                profile2_layout.setVisibility(View.VISIBLE);

                /*
                diaryTextView.setVisibility(View.VISIBLE);
                profile2_box.setVisibility(View.VISIBLE);
                save_Btn.setVisibility(View.VISIBLE);
                contextEditText.setVisibility(View.VISIBLE);

                 */

                profile_layout.setVisibility(View.INVISIBLE);

                /*
                textView2.setVisibility(View.INVISIBLE);
                profile2_box1.setVisibility(View.INVISIBLE);
                profile2_memo.setVisibility(View.INVISIBLE);
                cha_Btn.setVisibility(View.INVISIBLE);
                del_Btn.setVisibility(View.INVISIBLE);
                 */


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("WrongConstant")
    public void removeDiary(String readDay) {
        FileOutputStream fos;

        try {
            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content = "빈 메모";
            fos.write((content).getBytes());
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("WrongConstant")
    public void saveDiary(String readDay) {
        FileOutputStream fos;

        try {
            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content = contextEditText.getText().toString();
            fos.write((content).getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClick_handler(View view) {
        Intent intent = new Intent(profile1.this, profile1.class);

        startActivity(intent);

    }
//

    public class SaturdayDecorator implements DayViewDecorator {
        private final Calendar calendar = Calendar.getInstance();
        public SaturdayDecorator(){}
        @Override
        public boolean shouldDecorate(CalendarDay day){
            day.copyTo(calendar);
            int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
            return weekDay == Calendar.SATURDAY;
        }
        @Override
        public void decorate(DayViewFacade view){
            view.addSpan(new ForegroundColorSpan(Color.parseColor("#87CEEB")));
        }
    }

    public class SundayDecorator implements DayViewDecorator {
        private final Calendar calendar = Calendar.getInstance();
        public SundayDecorator(){}
        @Override
        public boolean shouldDecorate(CalendarDay day){
            day.copyTo(calendar);
            int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
            return weekDay == Calendar.SUNDAY;
        }
        @Override
        public void decorate(DayViewFacade view){
            view.addSpan(new ForegroundColorSpan(Color.parseColor("#DC143C")));
        }
    }
    public class OneDayDecorator implements  DayViewDecorator {
        private CalendarDay date;


        public OneDayDecorator(){
            date = CalendarDay.today();
        }
        @Override
        public boolean shouldDecorate(CalendarDay day){
            return day.equals(date);
        }
        @Override
        public void decorate(DayViewFacade view){
            view.addSpan(new StyleSpan(Typeface.BOLD));
            view.addSpan(new RelativeSizeSpan(1.4f));
            view.addSpan(new ForegroundColorSpan(Color.parseColor("#FFDC00")));
        }
        public void setDate(Date date){
            this.date = CalendarDay.from(date);
        }

    }
    public class EventDecorator implements DayViewDecorator {


        private final int color;
        private final HashSet<CalendarDay> dates;

        public EventDecorator(int color, Collection<CalendarDay> dates) {

            this.color = color;
            this.dates = new HashSet<>(dates);
        }

        @Override
        public boolean shouldDecorate(CalendarDay day) {
            return dates.contains(day);
        }

        @Override
        public void decorate(DayViewFacade view) {
            view.addSpan(new DotSpan(5, color));
        }
    }



    private class ApiSimulator extends AsyncTask<Void, Void, List<CalendarDay>> {

        String[] Time_Result;

        ApiSimulator(String[] Time_Result) {
            this.Time_Result = Time_Result;
        }

        @Override
        protected List<CalendarDay> doInBackground(@NonNull Void... voids) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Calendar calendar = Calendar.getInstance();
            ArrayList<CalendarDay> dates = new ArrayList<>();

            /*특정날짜 달력에 점표시해주는곳*/
            /*월은 0이 1월 년,일은 그대로*/
            //string 문자열인 Time_Result 을 받아와서 ,를 기준으로짜르고 string을 int 로 변환
            for (int i = 0; i < Time_Result.length; i++) {
                CalendarDay day = CalendarDay.from(calendar);
                String[] time = Time_Result[i].split(",");
                int year = Integer.parseInt(time[0]);
                int month = Integer.parseInt(time[1]);
                int dayy = Integer.parseInt(time[2]);

                dates.add(day);
                calendar.set(year, month - 1, dayy);
            }


            return dates;
        }
        @Override
        protected void onPostExecute(@NonNull List<CalendarDay> calendarDays) {
            super.onPostExecute(calendarDays);

            if (isFinishing()) {
                return;
            }

        }
    }




    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);

        updateTimeText(c);
        startAlarm(c);
        img_alarmpupple = findViewById(R.id.alarm_Btn);
        img_alarmpupple.setBackgroundResource(R.drawable.img_alarmpupple);

    }

    private void updateTimeText(Calendar c){
        String timeText = "Alarm set for : ";
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());

        mTextView.setText(timeText);
    }

    private void startAlarm(Calendar c){
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        if(c.before((Calendar.getInstance()))){
            c.add(Calendar.DATE, 1);
        }
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
        //alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), 1*60*1000 ,  pendingIntent);

    }

    public void mOnClick(View v) {

        Intent i;

        if(v.getId() == R.id.home){
            i = new Intent(profile1.this,  MainActivity.class);
            i.putExtra("userID",userID);
            startActivity(i);
        } else if(v.getId() == R.id.search){
            i = new Intent(profile1.this, search1.class);
            i.putExtra("userID",userID);
            startActivity(i);
        } else if(v.getId() == R.id.ticket || v.getId() == R.id.ticket2){
            i = new Intent(profile1.this, reservation_ticket.class);
            i.putExtra("userID",userID);
            startActivity(i);
        }else if (v.getId() == R.id.position){
            i = new Intent(profile1.this, MapsActivity.class);
            i.putExtra("userID",userID);
            startActivity(i);
        } else if(v.getId() == R.id.profile_icon){
            Intent intent = new Intent(profile1.this, profile1.class);
            intent.putExtra("userID",userID);
            startActivity(intent);
        } else if (v.getId() == R.id.img_favorite && favorite_t == true) {
            favorite.setImageResource(R.drawable.purple_heart);
            favorite_t = false;

        } else if (v.getId() == R.id.img_favorite && favorite_t == false) {
            favorite.setImageResource(R.drawable.icon_action_favorite);
            favorite_t = true;

        } else if (v.getId() == R.id.img_ticket_book && book_mark_t == true) {
            book_mark.setImageResource(R.drawable.purple_bookmark);
            book_mark_t = false;
            i = new Intent(profile1.this, ticket_book.class);
            startActivity(i);

        } else if (v.getId() == R.id.img_ticket_book && book_mark_t == false) {
            book_mark.setImageResource(R.drawable.icon_bookmark);
            book_mark_t = true;

        } else if (v.getId() == R.id.img_setting) {
            i = new Intent(profile1.this, setting.class);
            startActivity(i);
        }
    }
}
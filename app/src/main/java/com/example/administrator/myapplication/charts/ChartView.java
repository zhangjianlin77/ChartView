package com.example.administrator.myapplication.charts;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.myapplication.charts.time.TimeChartCursor;
import com.example.administrator.myapplication.charts.time.TimeTodayChartView;
import com.example.administrator.myapplication.charts.time.TimeTodayCursorView;

/**
 * Created by wudashan on 2015/11/27 0027.
 */
public class ChartView extends RelativeLayout implements RefreshLoadingView.LoadingViewListener{
//    private static final String TAG_5TODAY = "TAG_5TODAY";
//    private static final String TAG_KDAY = "TAG_KDAY";
//    private static final String TAG_KMONTH = "TAG_KMONTH";
//    private static final String TAG_KWEEK = "TAG_KWEEK";
//    private static final String TAG_TODAY = "TAG_TODAY";
    private ChartRefreshCallback chartRefreshCallback;
//    private TabHost chartTabHost;
    private float cursorTextSizeBig;
    private float cursorTextSizeMedium;
    private float cursorTextSizeSmall;
//    private FullScreenListener fullScreenListener;
//    private TextView mBackButton;
//    private ImageButton mRefreshButton;
//    private TextView mStockinfo;
//    private TextView mTimeCursorAvgPrice;
//    private TextView mTimeCursorPrice;
//    private TextView mTimeCursorTime;
//    private TextView mTimeCursorVolume;
//    private View refreshLoading;
    private ViewGroup root;
//    private TabWidget tabWidget;
//    private RelativeLayout timeCursorBar;
    private TimeTodayChartView timeTodayChartView;
    private TimeTodayCursorView timeTodayCursorView;
//    private RelativeLayout titleBar;
//    private TextView updataTime;


    public ChartView(Context context){
        super(context);
    }

    public ChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void initLayout(String stockType, String stockCode){
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500));

        timeTodayChartView = new TimeTodayChartView(this, stockType, stockCode);
        addView(timeTodayChartView);
        timeTodayCursorView = new TimeTodayCursorView(timeTodayChartView);
        addView(timeTodayCursorView);
    }

    private void onTimeChartCursor(TimeChartCursor timeChartCursor, String s){
//        String temp = timeTodayChartView.formatPrice(timeChartCursor.price) + "(" + StringHandler.formatPercent(timeChartCursor.percent, 2, false, false) + ")";
//        mTimeCursorAvgPrice.setText(temp);
//        if (timeChartCursor.percent >= 0.0f){
//            mTimeCursorPrice.setTextColor(timeTodayChartView.upColor);
//        } else {
//            mTimeCursorPrice.setTextColor(timeTodayChartView.downColor);
//        }
//        mTimeCursorAvgPrice.setText(timeTodayChartView.formatPrice(timeChartCursor.avgPrice));
//        temp = timeChartCursor.volumeForTouch + s;
//        mTimeCursorVolume.setText(temp);
//        mTimeCursorTime.setText(timeChartCursor.time);
    }

    public void onTimeTodayChartCursor(TimeChartCursor timeChartCursor, String s){
        timeTodayCursorView.setCursor(timeChartCursor);
        timeTodayCursorView.postInvalidate();
        onTimeChartCursor(timeChartCursor, s);
    }

    public void refreshChart(){
        timeTodayChartView.refreshChart();
        ///test
        int size = timeTodayChartView.items.size();
        onTimeTodayChartCursor(timeTodayChartView.items.get(size - 1), "");
        ///test
    }

    public void onCursorRemoved(){
        this.timeTodayCursorView.setCursor(null);
        this.timeTodayChartView.postInvalidate();
    }




    @Override
    public void hiddenAutoLoading(View paramView) {

    }

    @Override
    public void showAutoLoading(View paramView) {

    }


    public  interface FullScreenListener{
        void onEnterFullScreen();
        void onExitFullScreen();
    }
}

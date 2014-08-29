package mobi.unam.smarty;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.astuetz.PagerSlidingTabStrip;

import mobi.unam.smarty.adapters.MyPagerAdapter;
import mobi.unam.smarty.fragments.FragmentMap;
import mobi.unam.smarty.fragments.FragmentPrueba;
import mobi.unam.smarty.fragments.FragmentRoutes;
import mobi.unam.smarty.utilities.AccordionTransformer;
import mobi.unam.smarty.utilities.StackTransformer;


public class Smarty extends ActionBarActivity implements ViewPager.OnPageChangeListener {

    private MyPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smarty);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        adapter = new MyPagerAdapter(getSupportFragmentManager());
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);

        adapter.addFragment(FragmentMap.newInstance(), R.drawable.selector_ubica);
        adapter.addFragment(new FragmentPrueba(), R.drawable.selector_viaja);
        adapter.addFragment(new FragmentRoutes(), R.drawable.selector_rutas);

        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(true, new StackTransformer());
        tabs.setViewPager(viewPager);
        tabs.setOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int i, float v, int i2) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.smarty, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}

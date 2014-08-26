package mobi.unam.smarty.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider{

	private ArrayList<Fragment> fragments;
	private ArrayList<Integer> pagerIcons;


	public MyPagerAdapter(FragmentManager manager) {
		super(manager);
		fragments = new ArrayList<Fragment>();
		pagerIcons = new ArrayList<Integer>();
	}

	public void addFragment(Fragment fragment, int idIcon)
    {
		fragments.add(fragment);
        pagerIcons.add(idIcon);
	}

//	@Override
//	public CharSequence getPageTitle(int position) {
//		return titulos.get(position);
//	}

	
	@Override
	public Fragment getItem(int arg0) {
		return fragments.get(arg0);
	}

	@Override
	public int getCount() {
		return fragments.size();
	}

    @Override
    public int getPageIconResId(int i) {
        return pagerIcons.get(i);

    }


}

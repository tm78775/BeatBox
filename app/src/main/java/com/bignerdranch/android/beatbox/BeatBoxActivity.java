package com.bignerdranch.android.beatbox;

import android.app.Fragment;

public class BeatBoxActivity extends SingleFragmentActivity {

    public Fragment createFragment() {
        BeatBoxFragment fragment = BeatBoxFragment.newInstance();
        return fragment;
    }

}

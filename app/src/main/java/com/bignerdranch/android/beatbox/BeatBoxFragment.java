package com.bignerdranch.android.beatbox;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;


/**
 * Controller class that modifies and maintains View elements and UI.
 */
public class BeatBoxFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private BeatBox mBeatBox;

    public static BeatBoxFragment newInstance() {
        return new BeatBoxFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        mBeatBox = new BeatBox(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // 1 - Inflate the view.
        View view = inflater.inflate(R.layout.fragment_beat_box, container, false);
        // 2 - get reference to the view widgets.
        mRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_beat_box_recycler_view);
        // 3 - give recyclerview a layout manager (or app will crash). The 3 indicates number of columns in the grid.
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        // 4 - wire up Recycler View's adapter.
        mRecyclerView.setAdapter(new SoundAdapter(mBeatBox.getSounds()));

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBeatBox.release();
    }

    /*
     *  This class extends the RecyclerView.ViewHolder class. The RecyclerView will pass an instance
     *  of THIS class to the Adapter class.
     */
    private class SoundHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Button mButton;
        private Sound mSound;

        @Override
        public void onClick(View view) {
            mBeatBox.play(mSound);
        }

        public SoundHolder(LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.list_item_sound, container, false));
            mButton = (Button) itemView.findViewById(R.id.list_item_sound_button);
            mButton.setOnClickListener(this);
        }

        public void bindSound(Sound sound) {
            mSound = sound;
            mButton.setText(mSound.getName());
        }
    }


    /*
     *  This class extends the RecyclerView.Adapter class. The RecyclerView will pass an empty
     *  ViewHolder object to the adapter. This adapter will instantiate the ViewHolder object, fill
     *  it with data, and pass it back to the RecyclerView.
     */
    private class SoundAdapter extends RecyclerView.Adapter<SoundHolder> {

        private List<Sound> mSounds;

        public SoundAdapter(List<Sound> sounds) {
            mSounds = sounds;
        }

        @Override
        public SoundHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new SoundHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(SoundHolder holder, int position) {
            Sound sound = mSounds.get(position);
            holder.bindSound(sound);
        }

        @Override
        public int getItemCount() {
            return mSounds.size();
        }
    }
}

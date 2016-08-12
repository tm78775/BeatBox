package com.bignerdranch.android.beatbox;

/**
 * Model class designed to hold all variables relating to Sound.
 */
public class Sound {

    // member variables
    private String mAssetPath;
    private String mName;
    private int mSoundId;

    public Sound(String assetPath) {
        mAssetPath = assetPath;
        String[] components = assetPath.split("/");
        String filename = components[components.length - 1];
        mName = filename.replace(".wav", "");
    }

    // getters and setters
    public String getAssetPath() { return mAssetPath; }
    public void setAssetPath(String assetPath) { mAssetPath = assetPath; }

    public String getName() { return mName; }
    public void setName(String name) { mName = name; }

    public int getSoundId() { return mSoundId; }
    public void setSoundId(int soundId) { mSoundId = soundId; }
}

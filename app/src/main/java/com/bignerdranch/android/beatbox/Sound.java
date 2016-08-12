package com.bignerdranch.android.beatbox;

/**
 * Created by TMiller on 8/12/2016.
 */
public class Sound {

    // member variables
    private String mAssetPath;
    private String mName;

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
}

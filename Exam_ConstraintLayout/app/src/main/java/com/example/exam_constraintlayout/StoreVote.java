package com.example.exam_constraintlayout;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class StoreVote {
    private String name;
    private int voteCount;

    public StoreVote(String name,int vote) {
        this.name = name;
        this.voteCount = vote;
        System.out.println(this.name);
        System.out.println(this.voteCount);
        Log.d("1 vote for",this.name);
        Log.d("count is",Integer.toString(this.voteCount));
    }

    public String getName() {
        return name;
    }

    public int getVoteCount() {
        return voteCount;
    }
}


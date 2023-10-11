package com.example.jetpackcomposeplayground;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;

import java.util.Objects;

public final class aux extends AdListener {

    public final  FrameLayout f15669class;
    public final  AdView f15670const;
    public final  ShimmerFrameLayout f15671do;
    public final  String f15673super;
    public aux(ShimmerFrameLayout shimmerFrameLayout, FrameLayout frameLayout, AdView adView, String str) {
        this.f15671do = shimmerFrameLayout;
        this.f15669class = frameLayout;
        this.f15670const = adView;
        this.f15673super = str;
    }

    @Override
    public void onAdClicked() {
        super.onAdClicked();
    }

    @Override
    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
        super.onAdFailedToLoad(loadAdError);
        this.f15671do.stopShimmer();
        this.f15669class.setVisibility(View.GONE);
        this.f15671do.setVisibility(View.GONE);
    }

    @Override
    public void onAdLoaded() {
        Objects.requireNonNull(this.f15670const.getResponseInfo()).getMediationAdapterClassName();
        this.f15671do.stopShimmer();
        this.f15671do.setVisibility(View.GONE);
        this.f15669class.setVisibility(View.VISIBLE);
    }
}
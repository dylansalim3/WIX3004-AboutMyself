package com.dylansalim.aboutmyself;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OnboardingAdapter extends RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder> {
    private List<ScreenItem> mListScreen;

    public OnboardingAdapter(List<ScreenItem> mListScreen) {
        this.mListScreen = mListScreen;
    }

    @NonNull
    @Override
    public OnboardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OnboardingViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.layout_screen, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull OnboardingViewHolder holder, int position) {
        holder.setOnBoardingData(mListScreen.get(position));
    }

    @Override
    public int getItemCount() {
        return mListScreen.size();
    }

    public class OnboardingViewHolder extends RecyclerView.ViewHolder {
        ImageView imgSlide;
        TextView title;
        TextView description;

        public OnboardingViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSlide = itemView.findViewById(R.id.imageOnboarding);
            title = itemView.findViewById(R.id.textTitle);
            description = itemView.findViewById(R.id.textDescription);
        }

        void setOnBoardingData(ScreenItem screenItem){
            title.setText(screenItem.getTitle());
            description.setText(screenItem.getDescription());
            imgSlide.setImageResource(screenItem.getScreenImg());
        }
    }
}

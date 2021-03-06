package wedding.karpov.invitation.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import wedding.karpov.invitation.InvitationApplication;
import wedding.karpov.invitation.Main;
import wedding.karpov.invitation.R;
import wedding.karpov.invitation.objects.CustomTypefaceSpan;

/**
 * Created by akarpov on 1/14/15.
 */
public class WhereFragment extends Fragment {

    TextView mWhereTW;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_where, container, false);
        mWhereTW = (TextView) v.findViewById(R.id.where_text);
        return v;
    }


    @Override
    public void onStart() {
        super.onStart();
        SpannableStringBuilder builder = new SpannableStringBuilder();
        builder.append(getIssueDateText());
        builder.append(getStylingText(getString(R.string.about_kolomna_1)))
                .append("\n\n")
                .append(getStylingText(getString(R.string.about_kolomna_2)))
                .append("\n\n")
                .append(getStylingText(getString(R.string.about_kolomna_3)))
                .append("\n\n")
                .append(getStylingText(getString(R.string.about_kolomna_4)))
                .append("\n\n")
                .append(getStylingText(getString(R.string.about_kolomna_5)))
                .append("\n\n")
                .append(getStylingText(getString(R.string.about_kolomna_6)));
        mWhereTW.setText(builder);
    }

    private CharSequence getIssueDateText() {
        SpannableStringBuilder builder = new SpannableStringBuilder(getString(R.string.where_text));
//        builder.setSpan(new ForegroundColorSpan(
//                getResources().getColor(
//                        R.color.guest_name_color)), 0, 15,
//                SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.setSpan(new ForegroundColorSpan(
                getResources().getColor(
                        R.color.accent)), 15, 38, SpannableStringBuilder.SPAN_COMPOSING);
//        builder.setSpan(new ForegroundColorSpan(
//                getResources().getColor(
//                        R.color.guest_name_color)), 38, 45,
//                SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.setSpan(new ForegroundColorSpan(
                getResources().getColor(
                        R.color.accent)), 45, builder.length(), Spanned.SPAN_COMPOSING);
        builder.setSpan(new RelativeSizeSpan(1.4f), 0, builder.length(),
                Spanned.SPAN_COMPOSING);
        return builder;
    }

    private CharSequence getStylingText(CharSequence text) {
        SpannableString builder = new SpannableString(text);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(
                getResources().getColor(
                        R.color.guest_name_color));
        StyleSpan styleSpan = new StyleSpan(Typeface.NORMAL);
        builder.setSpan(styleSpan, 0, 1, Spanned.SPAN_COMPOSING);
        builder.setSpan(foregroundColorSpan, 0, 1, Spanned.SPAN_COMPOSING);
        builder.setSpan(new RelativeSizeSpan(1.8f), 0, 1,
                Spanned.SPAN_COMPOSING);
        builder.setSpan(new RelativeSizeSpan(1.2f), 1, builder.length(),
                Spanned.SPAN_COMPOSING);
        return builder;
    }
}

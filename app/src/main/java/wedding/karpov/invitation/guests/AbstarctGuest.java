package wedding.karpov.invitation.guests;

import com.parse.ParseObject;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;

import wedding.karpov.invitation.R;
import wedding.karpov.invitation.objects.CustomTypefaceSpan;

/**
 * Created by arsenitykarpov on 14/01/15.
 */
public abstract class AbstarctGuest implements Guest {

    private Context mContext;

    private boolean mIsApproved = false;

    protected AbstarctGuest(Context context) {
        mContext = context;
    }

    @Override
    public CharSequence getWelcomeText() {
        SpannableStringBuilder text = SpannableStringBuilder.valueOf(getStylingName());
        text.append("\n\n");
        text.append(getStylingWelcomeText());
        text.append(getStylingSignature());
        return text;
    }

    protected CharSequence getStylingSignature() {
        SpannableString builder = new SpannableString("Арсентий и Евгения");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(
                mContext.getResources().getColor(
                        R.color.guest_name_color));
        StyleSpan styleSpan = new StyleSpan(Typeface.NORMAL);
        builder.setSpan(styleSpan, 0, builder.length(), Spanned.SPAN_COMPOSING);
        builder.setSpan(foregroundColorSpan, 0, builder.length(), Spanned.SPAN_COMPOSING);
        builder.setSpan(new RelativeSizeSpan(1.2f), 0, builder.length(),
                Spanned.SPAN_COMPOSING);
        return builder;
    }

    protected CharSequence getStylingName() {
        SpannableString builder = new SpannableString(getPrefix() + " " + getName() + "!");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(
                mContext.getResources().getColor(
                        R.color.guest_name_color));
        StyleSpan styleSpan = new StyleSpan(Typeface.NORMAL);
        builder.setSpan(styleSpan, 0, builder.length(), Spanned.SPAN_COMPOSING);
        builder.setSpan(foregroundColorSpan, 0, builder.length(), Spanned.SPAN_COMPOSING);
        builder.setSpan(new RelativeSizeSpan(1.3f), 0, builder.length(),
                Spanned.SPAN_COMPOSING);
        return builder;
    }

    private CharSequence getPrefix() {
        return GuestType.FRIEND == getType() ? (GuestGender.M == getGender() ? "Достопочтенный"
                : (GuestGender.P == getGender() ? "Достопочтенные" : "Достопочтенная"))
                : (GuestGender.M == getGender() ? "Дорогой"
                        : (GuestGender.P == getGender() ? "Дорогие" : "Дорогая"));
    }

    protected CharSequence getStylingWelcomeText() {
        SpannableString builder = new SpannableString(mContext.getString(getResourceId()));
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(
                mContext.getResources().getColor(
                        R.color.guest_name_color));
        StyleSpan styleSpan = new StyleSpan(Typeface.NORMAL);
        builder.setSpan(styleSpan, 0, builder.length(), Spanned.SPAN_COMPOSING);
        builder.setSpan(new RelativeSizeSpan(1.2f), 0, builder.length(),
                Spanned.SPAN_COMPOSING);
        return builder;
    }

    @Override
    public void approve(OnApproveListener listener) {
        mIsApproved = true;
        listener.onApprove();
    }

    protected int getResourceId() {
        return GuestType.FRIEND == getType() ? R.string.welcome_text_friends
                : R.string.welcome_text_relatives;
    }

    @Override
    public boolean isApproved() {
        return mIsApproved;
    }

    public static interface OnApproveListener {

        void onApprove();
    }

}

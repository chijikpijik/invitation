package wedding.karpov.invitation.guests;

import android.content.Context;

import wedding.karpov.invitation.R;

/**
 * Created by akarpov on 1/28/15.
 */
public class ShapiroGuest extends AbstarctGuest {

    public ShapiroGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Диман";
    }

    @Override
    public GuestType getType() {
        return GuestType.FRIEND;
    }

    @Override
    public GuestGender getGender() {
        return GuestGender.M;
    }

}

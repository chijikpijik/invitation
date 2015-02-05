package wedding.karpov.invitation.guests;

import android.content.Context;

/**
 * Created by akarpov on 2/5/15.
 */
public class ZinjaGuest extends AbstarctGuest {

    public ZinjaGuest(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Зиня";
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
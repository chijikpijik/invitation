package wedding.karpov.invitation;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.TimeZone;

import wedding.karpov.invitation.guests.Guest;
import wedding.karpov.invitation.guests.helpers.GuestFactory;

/**
 * Created by akarpov on 1/13/15.
 */
public class LoginScreenGenerator implements OverlappingScreen.InformationScreenGenerator {

    @Override
    public View getView(final OverlappingScreen overlappingInformationScreen) {
        LayoutInflater layoutInflater = overlappingInformationScreen.getActivity()
                .getLayoutInflater();
        final View v = layoutInflater.inflate(R.layout.view_login, null);
        v.findViewById(R.id.login_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Guest guest = GuestFactory
                        .getGuestByCode(((EditText) v.findViewById(R.id.code)).getText().toString(),
                                overlappingInformationScreen.getActivity());
                if (guest != null) {
                    ParseObject guestAnswerObject = new ParseObject("LoginCounter");
                    guestAnswerObject.put("name", guest.getName());
                    guestAnswerObject.put("login", "true");
                    guestAnswerObject.saveEventually();
                    overlappingInformationScreen
                            .detach(new OverlappingScreen.OnAnimationListener() {
                                @Override
                                public void onEnd() {

                                }

                                @Override
                                public void onStart() {
                                    InputMethodManager imm
                                            = (InputMethodManager) overlappingInformationScreen
                                            .getActivity()
                                            .getSystemService(Context.INPUT_METHOD_SERVICE);
                                    imm.hideSoftInputFromWindow(
                                            v.findViewById(R.id.code).getWindowToken(), 0);
                                }
                            });
                    ((InvitationApplication) (overlappingInformationScreen
                            .getActivity()
                            .getApplication())).setGuest(guest);
                    ((Main) overlappingInformationScreen.getActivity())
                            .updateGuestContent();
                } else {
                    Toast.makeText(overlappingInformationScreen.getActivity(),
                            overlappingInformationScreen.getActivity()
                                    .getString(R.string.login_wrong_code), Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
        return v;
    }

}

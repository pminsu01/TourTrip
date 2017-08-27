package start.june.tour;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by ubunms on 17. 5. 12.
 */

public class ProgressDialog extends Dialog {

    Context mContext;
    public ProgressDialog(Context context) {
        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        mContext =context;

    }

    @Override

    protected void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        setContentView(R.layout.progress_activity);
    }


}

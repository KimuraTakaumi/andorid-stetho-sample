package com.hatenablog.techium.andorid_stetho_sample;

import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumpUsageException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class TimeMeasurementDumperPlugin implements DumperPlugin {

    private static final String NAME = "time";

    private static final String USAGE = "Usage: dumpapp " + NAME + " <length>";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void dump(DumperContext dumpContext) throws DumpException {
        PrintStream writer = dumpContext.getStdout();
        Iterator<String> args = dumpContext.getArgsAsList().iterator();

        String length = args.hasNext() ? args.next() : null;
        try {
            int len = Integer.valueOf(length);
            if (len >= 0) {
                doHistory(writer, len);
            } else {
                throw new DumpUsageException(USAGE);
            }
        } catch (NumberFormatException e) {
            throw new DumpUsageException(USAGE);
        }
    }

    private void doHistory(PrintStream writer, int length) throws DumpUsageException {
        ArrayList<String> list = ClickManager.getInstance().getHistory();

        for (int i = 0; i < list.size(); i++) {
            if (length < i) {
                break;
            }
            writer.println(list.get(i));
        }
    }
}

package com.brentandjody.Translator;

/**
 * Created by brent on 01/12/13.
 */
public class RawStrokeTranslator extends Translator {

    private boolean locked=false;

    @Override
    public boolean usesDictionary() {
        return false;
    }

    @Override
    public void lock() {
        locked=true;
    }

    @Override
    public void unlock() {
        locked=false;
    }

    @Override
    public TranslationResult translate(Stroke stroke) {
        if (locked) return null;
        StringBuilder sb = new StringBuilder();

        for (String s : Stroke.STENO_KEYS) {
            if (stroke.getKeys().contains(s)) {
                sb.append(s.replace("-",""));
            } else {
                sb.append("_");
            }
        }
        sb.append("\n");
        return new TranslationResult(0, sb.toString(), null);
    }
}

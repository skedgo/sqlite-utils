package skedgo.sqlite;

import android.database.Cursor;

import rx.Observable;
import rx.functions.Func1;

/**
 * Provides some util methods related to {@link Cursor}.
 */
public final class Cursors {
  private Cursors() {}

  /**
   * Emits all the available rows of a {@link Cursor}.
   * This should be composed with {@link Observable#flatMap(Func1)}.
   */
  public static Func1<Cursor, Observable<Cursor>> flattenCursor() {
    return new Func1<Cursor, Observable<Cursor>>() {
      @Override public Observable<Cursor> call(Cursor cursor) {
        return Observable.create(new OnSubscribeCursor(cursor));
      }
    };
  }
}
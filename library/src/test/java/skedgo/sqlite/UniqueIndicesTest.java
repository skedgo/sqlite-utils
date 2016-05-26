package skedgo.sqlite;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class UniqueIndicesTest {
  @Test public void uniqueIndexOnFields() {
    final DatabaseField objectId = new DatabaseField("object_id", "TEXT");
    final DatabaseField type = new DatabaseField("type", "INTEGER");
    assertThat(UniqueIndices.of("favorites", objectId, type))
        .isEqualTo("CREATE UNIQUE INDEX favorites_UI_object_id_type ON favorites (object_id, type);");
  }

  @Test public void uniqueIndexOnOneField() {
    final DatabaseField objectId = new DatabaseField("object_id", "TEXT");
    assertThat(UniqueIndices.of("favorites", objectId))
        .isEqualTo("CREATE UNIQUE INDEX favorites_UI_object_id ON favorites (object_id);");
  }
}
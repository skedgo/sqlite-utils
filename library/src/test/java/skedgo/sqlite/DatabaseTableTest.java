package skedgo.sqlite;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class DatabaseTableTest {
  @Test public void shouldGeneratePrettySqlCreationText() {
    final DatabaseTable table = new DatabaseTable(
        "locations",
        new DatabaseField[] {
            new DatabaseField("lat", "REAL"),
            new DatabaseField("lon", "REAL"),
            new DatabaseField("name", "TEXT", "COLLATE NOCASE"),
        });
    assertThat(table.getCreateSql())
        .isEqualTo("CREATE TABLE locations (lat REAL, lon REAL, name TEXT COLLATE NOCASE)");
  }
}
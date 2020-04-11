package cfvbaibai.tbourse.account;

import java.util.UUID;

public class CardMetaInfo {
    private UUID uuid;

    public CardMetaInfo(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}

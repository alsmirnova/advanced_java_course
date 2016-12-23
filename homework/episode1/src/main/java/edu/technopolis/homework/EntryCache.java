package adv_java.LFU_cache;

/**
 * Created by Алена on 23.12.2016.
 */
public class EntryCache {

        private String data;
        private int frequency;

        // default constructor
        public EntryCache() {
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }




    }
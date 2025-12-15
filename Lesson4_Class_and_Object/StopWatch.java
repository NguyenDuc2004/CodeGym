public class StopWatch
{
        private long startTime;
        private long endTime;

        // Constructor không tham số
        public StopWatch() {
            startTime = System.currentTimeMillis();
        }

        // Getter
        public long getStartTime() {
            return startTime;
        }

        public long getEndTime() {
            return endTime;
        }

        // Reset startTime
        public void start() {
            startTime = System.currentTimeMillis();
        }

        public void stop() {
            endTime = System.currentTimeMillis();
        }

        public long getElapsedTime() {
            return endTime - startTime;
        }
    }


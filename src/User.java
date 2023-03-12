public class User {
    int rank;
    int progress;

    public User () {
        this.rank = -8;
        this.progress = 0;
    }

    public void incProgress(int activityRank) {
        if ((activityRank < 9) || (activityRank > -9) || (activityRank == 0))
            throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");

        if (rank != 8) {
            if (activityRank == rank) {
                progress += 3;
            } else if (activityRank == rank - 1) {
                progress += 1;
            } else if (activityRank > rank) {
                progress += 10 * (activityRank - rank) * (activityRank - rank);
            }

            if (progress >= 100) {
                if (rank == 7) {
                    rank = 8;
                    progress = 0;
                }
                else if (rank == -1)
                    rank = 1;
                else
                    rank++;
                progress = progress - 100;
            }
        }
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "User{" +
                "rank=" + rank +
                ", progress=" + progress +
                '}';
    }
}

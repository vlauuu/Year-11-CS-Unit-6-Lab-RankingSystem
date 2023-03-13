public class User {

    private int rank;
    private int progress;

    public User ()
    {
        this.rank = -8;
        this.progress = 0;

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

    public void incProgress(int activityRank)
    {
        if (activityRank < -8 || activityRank == 0 || activityRank > 8)
        {
            throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        }
        if (activityRank == rank)
        {
            progress = progress + 3;
        }
        else if (rank > activityRank && rank - activityRank == 1)
        {
            progress = progress + 1;
        }
        else if (rank == 1 && activityRank == -1)
        {
            progress = progress + 1;
        }
        else if (rank > activityRank && rank - activityRank >= 2)
        {
            return;
        }
        else if (activityRank > rank)
        {
            int d;
            if (activityRank >= 0 && rank < 0)
            {
                d = (activityRank - rank) - 1;
            }
            else
            {
                d = activityRank - rank;
            }

            progress = progress + (10 * d * d);
        }

        while (progress >= 100)
        {
            int newRank = rank + 1;
            if (rank == -1)
            {
                newRank = 1;
            }
            else if (rank == 8)
            {
                return;
            }
            rank = newRank;
            progress = progress - 100;
        }


    }
}

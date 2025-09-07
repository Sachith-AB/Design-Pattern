interface MediaPlayer {
    void play(String audioType, String fileName);
}

class Mp3Player {
    public void playMp3(String fileName) {
        System.out.println("Playing MP3 file: " + fileName);
    }
}

class Mp4Player {
    public void playMp4(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }
}

class VlcPlayer {
    public void playVlc(String fileName) {
        System.out.println("Playing VLC file: " + fileName);
    }
}

class MediaAdapter implements MediaPlayer {

    private Mp3Player mp3Player;
    private Mp4Player mp4Player;
    private VlcPlayer vlcPlayer;

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mp3")) {
            if(mp3Player == null) mp3Player = new Mp3Player();
            mp3Player.playMp3(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            if (mp4Player == null) mp4Player = new Mp4Player();
            mp4Player.playMp4(fileName);
        } else if (audioType.equalsIgnoreCase("vlc")) {
            if (vlcPlayer == null) vlcPlayer = new VlcPlayer();
            vlcPlayer.playVlc(fileName);
        } else {
            System.out.println("Invalid format: " + audioType);
        }
    }
}

public class FactoryDemo {

    public static void main(String[] args) {
        MediaPlayer player = new MediaAdapter();

        player.play("mp3", "song1.mp3");
        player.play("mp4", "video1.vlc");
        player.play("avi", "movie.avi");
    }
}
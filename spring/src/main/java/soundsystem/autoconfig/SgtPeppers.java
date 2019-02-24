package soundsystem.autoconfig;

import org.springframework.stereotype.Component;

@Component // 该注解告知Spring为这个类创建Bean
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}

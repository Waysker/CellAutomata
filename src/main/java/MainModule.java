import com.google.inject.AbstractModule;

public class MainModule extends AbstractModule {

    @Override
    protected void configure() {
//        here i would typically bind interfaces to their correct implementations
//        however there are no interfaces in this project and binding given class to itself is done by default
//        then no code here is required
//        bindings would look like this:
//        bind(Controller.class).to(Controller.class);
//        see https://github.com/google/guice/wiki/Motivation for reference
    }
}

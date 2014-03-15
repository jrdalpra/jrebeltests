package producerwithjrebel;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import producerwithjrebel.Autocompleter.Finder;

public class AutocompletersFactory {

    @Produces
    @Named
    @RequestScoped
    @SuppressWarnings("unchecked")
    public Autocompleter<String> namesAutocompleter() {
        return new Autocompleter<String>(new Finder<String>() {

            @Override
            public List<String> list(String query) {
                return Arrays.asList(query);
            }
        });
    }

    // @Produces
    // @Named
    // @RequestScoped
    // @SuppressWarnings("unchecked")
    // public Autocompleter<String> carsAutocompleter() {
    // return new Autocompleter<String>(new Finder<String>() {
    //
    // @Override
    // public List<String> list(String query) {
    // return Arrays.asList(query);
    // }
    // });
    // }

}

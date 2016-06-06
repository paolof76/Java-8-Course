package ch.diso.exercise.lambda.exercise2;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toSet;


/**
 * Some (inaccurate) London electrical districts
 */
public enum ElectoralDistrict {

    CROYDON("CR"),
    BARKING("BA"),
    HACKNEY("HA"),
    EDMONTON("ED");

    private final String prefix;

    ElectoralDistrict(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Complete this method to pass Exercise_2_Test#setOfVotersInDistrict()
     * 
     * @param district - District to vote in
     * @param voters - voters to filter
     * @return filtered set of registered voters in a district
     */
    public static Set<RegisteredVoter> votersIn(ElectoralDistrict district, Collection<RegisteredVoter> voters) {
        // [your code here]

        return voters.stream()
                .filter(v -> v.getElectorId().startsWith(district.prefix))
                .collect(collectingAndThen(toSet(), Collections::unmodifiableSet));

        // return Collections.emptySet();
    }

    /**
     * Complete this method to pass Exercise_2_Test#removeAllSpoiledBallots()
     * 
     * @param votes - votes to filter
     * @return filtered set of unspoiled ballots
     */
    public static Set<Ballot> unspoiledBallots(Set<Ballot> votes) {
        // [your code here]

        return Collections.emptySet();
    }

    public String getPrefix() {
        return prefix;
    }
}
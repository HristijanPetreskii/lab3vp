package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    public default List<Location> findAll() {
        return DataHolder.locationList;
    }

    public default Optional<Location> findById(Long id) {
        return DataHolder.locationList.stream().filter(location -> location.getId().equals(id)).findFirst();
    }
}

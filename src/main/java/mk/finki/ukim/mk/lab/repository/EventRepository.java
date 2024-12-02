package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.model.SavedBooking;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class EventRepository implements JpaRepository<Event, Long> {

    private List<SavedBooking> savedBookings = new ArrayList<>();

    List<Event> findAllByLocation_Id(Long locationId) {
        return null;
    }

    @Override
    public <S extends Event> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Event> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    public List<Event> findAll() {
        return DataHolder.eventList;
    }

    @Override
    public List<Event> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    public List<Event> searchEvents(String text) {
        return DataHolder.eventList.stream()
                .filter(event -> event.getName().toLowerCase().contains(text.toLowerCase()) ||
                                 event.getDescription().toLowerCase().contains(text.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<SavedBooking> getSavedBookings() {
        return savedBookings;
    }

    public Optional<Event> save(String name, String description, double popularityScore, Location location) {
        Event newEvent = new Event(name, description, popularityScore, location);
        DataHolder.eventList.removeIf(e -> Objects.equals(e.getName(), name));
        DataHolder.eventList.add(newEvent);
        return Optional.of(newEvent);
    }

    public Optional<Event> findById(Long id) {
        return DataHolder.eventList.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    public void deleteById(Long id) {
        DataHolder.eventList.removeIf(event -> Objects.equals(event.getId(), id));
    }

    @Override
    public void delete(Event entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Event> entities) {

    }

    @Override
    public void deleteAll() {

    }

    public void addBooking(String evName, int numTickets) {
        boolean bookinExists = false;
        for (SavedBooking booking : savedBookings) {
            if (booking.getEventName().equals(evName)) {
                booking.setNumberOfTickets(booking.getNumberOfTickets() + numTickets);
                bookinExists = true;
                break;
            }
        }

        if (!bookinExists) {
            savedBookings.add(new SavedBooking(evName, numTickets));
        }
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Event> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Event> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Event> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Event getOne(Long aLong) {
        return null;
    }

    @Override
    public Event getById(Long aLong) {
        return null;
    }

    @Override
    public Event getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Event> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Event> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Event> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Event> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Event> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Event> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Event, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<Event> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Event> findAll(Pageable pageable) {
        return null;
    }
}

package ca.bell.registration.mapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public interface Mapper<ENTITY, DTO> {

    ENTITY map(DTO dto, ENTITY entity);

    DTO map(ENTITY entity);

    default Optional<ENTITY> convertToEntity(DTO dto, ENTITY entity) {
        return dto == null || entity == null ? Optional.empty() : Optional.of(map(dto, entity));
    }

    default Optional<DTO> convertToDto(ENTITY entity) {
        return entity == null ? Optional.empty() : Optional.ofNullable(map(entity));
    }

    default Stream<DTO> convertToDto(List<ENTITY> entitys) {
        if (entitys != null) {
            return entitys.stream()
                    .map(e -> map(e));
        }
        return Stream.empty();
    }

    default Stream<DTO> convertToDto(Set<ENTITY> entitys) {
        if (entitys != null) {
            return entitys.stream()
                    .map(e -> map(e));
        }
        return Stream.empty();
    }

}

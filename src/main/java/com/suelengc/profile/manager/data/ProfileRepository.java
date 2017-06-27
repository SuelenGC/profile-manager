package com.suelengc.profile.manager.data;

import com.suelengc.profile.manager.model.Profile;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
    @Cacheable("profiles")
    Profile findByEmail(String email);
}
package org.example.adapters.db;

import org.example.adapters.db.models.CommonProductEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonProductRepository extends JpaRepository<CommonProductEntityModel, String> {
}

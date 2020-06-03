/**
 * Copyright (c) 2020, Self XDSD Contributors
 * All rights reserved.
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"),
 * to read the Software only. Permission is hereby NOT GRANTED to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software.
 * <p>
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY,
 * OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT
 * OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.selfxdsd.storage;

import com.selfxdsd.api.*;
import com.selfxdsd.api.storage.Storage;
import com.selfxdsd.core.StoredUser;
import com.selfxdsd.core.managers.StoredProjectManager;
import com.selfxdsd.core.projects.StoredProject;
import org.jooq.Record;
import org.jooq.Result;

import java.util.Iterator;

import static com.selfxdsd.storage.generated.jooq.tables.SlfPmsXdsd.SLF_PMS_XDSD;
import static com.selfxdsd.storage.generated.jooq.tables.SlfProjectsXdsd.SLF_PROJECTS_XDSD;
import static com.selfxdsd.storage.generated.jooq.tables.SlfUsersXdsd.SLF_USERS_XDSD;

/**
 * All the projects in Self.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 * @todo #15:30min Continue implementing and writing integration tests
 *  for SelfProject's methods.
 */
public final class SelfProjects implements Projects {

    /**
     * Parent Storage.
     */
    private final Storage storage;

    /**
     * Database.
     */
    private final Database database;

    /**
     * Ctor.
     * @param storage Parent Storage.
     * @param database Database.
     */
    public SelfProjects(
        final Storage storage,
        final Database database
    ) {
        this.storage = storage;
        this.database = database;
    }

    @Override
    public Project register(
        final Repo repo,
        final ProjectManager projectManager
    ) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public Projects assignedTo(final int projectManagerId) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public Projects ownedBy(final User user) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public Project getProjectById(
        final String repoFullName,
        final String repoProvider
    ) {
        try (final Database connected = this.database.connect()) {
            final Result<Record> result = connected.jooq()
                .select()
                .from(SLF_PROJECTS_XDSD)
                .join(SLF_USERS_XDSD)
                .on(
                    SLF_PROJECTS_XDSD.USERNAME.eq(SLF_USERS_XDSD.USERNAME).and(
                        SLF_PROJECTS_XDSD.PROVIDER.eq(SLF_USERS_XDSD.PROVIDER)
                    )
                )
                .join(SLF_PMS_XDSD)
                .on(
                    SLF_PROJECTS_XDSD.PMID.eq(SLF_PMS_XDSD.ID)
                )
                .where(
                    SLF_PROJECTS_XDSD.REPO_FULLNAME.eq(repoFullName).and(
                        SLF_PROJECTS_XDSD.PROVIDER.eq(repoProvider)
                    )
                )
                .fetch();
            if(!result.isEmpty()) {
                return this.projectFromRecord(result.get(0));
            }
        }
        return null;
    }

    @Override
    public Iterator<Project> iterator() {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    /**
     * Build a Project from a JOOQ Record.
     * @param rec Record representing the Project's data.
     * @return Project.
     */
    private Project projectFromRecord(final Record rec) {
        final User owner = new StoredUser(
            rec.getValue(SLF_USERS_XDSD.USERNAME),
            rec.getValue(SLF_USERS_XDSD.EMAIL),
            rec.getValue(SLF_USERS_XDSD.PROVIDER),
            this.storage
        );
        final Project built = new StoredProject(
            owner,
            rec.getValue(SLF_PROJECTS_XDSD.REPO_FULLNAME),
            new StoredProjectManager(
                rec.getValue(SLF_PMS_XDSD.ID),
                rec.getValue(SLF_PMS_XDSD.PROVIDER),
                rec.getValue(SLF_PMS_XDSD.ACCESS_TOKEN),
                this.storage
            ),
            this.storage
        );
        return built;
    }
}

/*
 *  Copyright 2015-2017 Richard, Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.richard.java.shiro.demo.base;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

/**
 * The description...
 * <p></p>
 *
 * @author Richard
 * @version 1.0.0
 */
public class BaseDao {

    private HibernateTemplate template;

    public HibernateTemplate getTemplate() {
        if (template == null) {
            this.setTemplate(new HibernateTemplate(this.getSessionFactory()));
        }
        return template;
    }

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public BaseDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * 计算翻页参数
     *
     * @param query
     * @param page
     * @return
     */
    protected PageParameter assemblePageParameter(Query query, PageParameter page) {
        query.setFirstResult(0);
        query.setMaxResults(0);
        int totalCount = query.list().size();
        page.setTotalCount(totalCount);
        int totalPage;
        if (page.getPageSize() > 0) {
            totalPage = totalCount / page.getPageSize()
                    + ((totalCount % page.getPageSize() == 0) ? 0 : 1);
        } else {
            totalPage = 1;
        }
        page.setTotalPage(totalPage);
        page.setStartIndex((page.getCurrentPage() - 1) * page.getPageSize());
        return page;
    }
}

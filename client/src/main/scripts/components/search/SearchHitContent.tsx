/*
 * MyTake.org website and tooling.
 * Copyright (C) 2018-2020 MyTake.org, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * You can contact us at team@mytake.org
 */
import React from "react";
import { SearchHit } from "./search";

export interface SearchHitContentProps {
  className?: string;
  searchHit: SearchHit;
}

const SearchHitContent: React.FC<SearchHitContentProps> = ({
  className,
  searchHit,
}) => {
  return (
    <p className={className}>
      {searchHit.getContent().map((hitContent) => {
        return hitContent.isHighlighted ? (
          <strong key={hitContent.text}>{hitContent.text}</strong>
        ) : (
          hitContent.text
        );
      })}
    </p>
  );
};

export default SearchHitContent;
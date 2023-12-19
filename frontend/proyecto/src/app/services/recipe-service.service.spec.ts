import { TestBed } from '@angular/core/testing';

import { RecipeServiceService } from './recipe.service';

describe('RecipeServiceService', () => {
  let service: RecipeServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RecipeServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

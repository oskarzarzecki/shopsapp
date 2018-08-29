import { ShopsAppModule } from './shops-app.module';

describe('ShopsAppModule', () => {
  let shopsAppModule: ShopsAppModule;

  beforeEach(() => {
    shopsAppModule = new ShopsAppModule();
  });

  it('should create an instance', () => {
    expect(shopsAppModule).toBeTruthy();
  });
});

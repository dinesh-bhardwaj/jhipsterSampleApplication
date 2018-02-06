/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_CATG_MASTERComponent } from '../../../../../../main/webapp/app/entities/rns-catg-master/rns-catg-master.component';
import { RNS_CATG_MASTERService } from '../../../../../../main/webapp/app/entities/rns-catg-master/rns-catg-master.service';
import { RNS_CATG_MASTER } from '../../../../../../main/webapp/app/entities/rns-catg-master/rns-catg-master.model';

describe('Component Tests', () => {

    describe('RNS_CATG_MASTER Management Component', () => {
        let comp: RNS_CATG_MASTERComponent;
        let fixture: ComponentFixture<RNS_CATG_MASTERComponent>;
        let service: RNS_CATG_MASTERService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_CATG_MASTERComponent],
                providers: [
                    RNS_CATG_MASTERService
                ]
            })
            .overrideTemplate(RNS_CATG_MASTERComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_CATG_MASTERComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_CATG_MASTERService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new RNS_CATG_MASTER(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.rNS_CATG_MASTERS[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
